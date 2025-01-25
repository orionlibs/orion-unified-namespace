let orionCommon =
{
    makeGetAJAXCall : function(url, callbackSuccessFunction, callbackFailFunction)
    {
        fetch(url,
        {
            method: 'GET',
            cache: "no-cache",
            mode: "cors",//cors, no-cors, same-origin
            credentials: "include",//include, same-origin, omit
            headers:
            {
                'Content-Type': 'application/json',
                'X-Xsrf-Token': orionCommon.getCookie('XSRF-TOKEN')
            }
        })
        .then(response =>
        {
            if(!response.ok)
            {
                if(callbackFailFunction)
                {
                    callbackFailFunction(response);
                }
                else
                {
                    throw new Error('Error ' + response.statusText);
                }
            }

            return response.json();
        })
        .then(jsonResponse =>
        {
            if(callbackSuccessFunction)
            {
                callbackSuccessFunction(jsonResponse);
            }
        })
        .catch(error =>
        {
            if(callbackFailFunction)
            {
                callbackFailFunction(error);
            }
            else
            {
                alert('There has been a problem with your fetch operation:' + error);
            }
        });
    },


    makePostAJAXCall : function(url, dataToSend, callbackSuccessFunction, callbackFailFunction)
    {
        fetch(url,
        {
            method: 'POST',
            cache: "no-cache",
            mode: "cors",//cors, no-cors, same-origin
            credentials: "include",//include, same-origin, omit
            headers:
            {
                'Content-Type': 'application/json',
                'X-Xsrf-Token': orionCommon.getCookie('XSRF-TOKEN')
            },
            body: JSON.stringify(dataToSend)
        })
        .then(response =>
        {
            if(!response.ok)
            {
                if(callbackFailFunction)
                {
                    callbackFailFunction(response);
                }
                else
                {
                    throw new Error('Error ' + response.statusText);
                }
            }

            return response.json();
        })
        .then(jsonResponse =>
        {
            if(callbackSuccessFunction)
            {
                callbackSuccessFunction(jsonResponse);
            }
        })
        .catch(error =>
        {
            if(callbackFailFunction)
            {
                callbackFailFunction(error);
            }
            else
            {
                alert('There has been a problem with your fetch operation:' + error);
            }
        });
    },


    makePutAJAXCall : function(url, dataToSend, callbackSuccessFunction, callbackFailFunction)
    {
        fetch(url,
        {
            method: 'PUT',
            cache: "no-cache",
            mode: "cors",//cors, no-cors, same-origin
            credentials: "include",//include, same-origin, omit
            headers:
            {
                'Content-Type': 'application/json',
                'X-Xsrf-Token': orionCommon.getCookie('XSRF-TOKEN')
            },
            body: JSON.stringify(dataToSend)
        })
        .then(response =>
        {
            if(!response.ok)
            {
                if(callbackFailFunction)
                {
                    callbackFailFunction(response);
                }
                else
                {
                    throw new Error('Error ' + response.statusText);
                }
            }

            return response.json();
        })
        .then(jsonResponse =>
        {
            if(callbackSuccessFunction)
            {
                callbackSuccessFunction(jsonResponse);
            }
        })
        .catch(error =>
        {
            if(callbackFailFunction)
            {
                callbackFailFunction(error);
            }
            else
            {
                alert('There has been a problem with your fetch operation:' + error);
            }
        });
    },


    makeDeleteAJAXCall : function(url, callbackSuccessFunction, callbackFailFunction)
    {
        fetch(url,
        {
            method: 'DELETE',
            cache: "no-cache",
            mode: "cors",//cors, no-cors, same-origin
            credentials: "include",//include, same-origin, omit
            headers:
            {
                'Content-Type': 'application/json',
                'X-Xsrf-Token': orionCommon.getCookie('XSRF-TOKEN')
            }
        })
        .then(response =>
        {
            if(!response.ok)
            {
                if(callbackFailFunction)
                {
                    callbackFailFunction(response);
                }
                else
                {
                    throw new Error('Error ' + response.statusText);
                }
            }

            return response.json();
        })
        .then(jsonResponse =>
        {
            if(callbackSuccessFunction)
            {
                callbackSuccessFunction(jsonResponse);
            }
        })
        .catch(error =>
        {
            if(callbackFailFunction)
            {
                callbackFailFunction(error);
            }
            else
            {
                alert('There has been a problem with your fetch operation:' + error);
            }
        });
    },


    uploadFile : async function(URL, fileInputID, callbackFunction)
    {
        const fileInput = document.getElementById(fileInputID);
        const files = fileInput.files;
        const formData = new FormData();

        for(let file of files)
        {
            formData.append('files[]', file);
        }

        try
        {
            const response = await fetch(URL,
            {
                method: 'POST',
                body: formData,
            });

            if(response.ok)
            {
                const result = await response.json();

                if(typeof callbackFunction === "function")
                {
                    callbackFunction(result);
                }
            }
            else
            {
                if(typeof callbackFunction === "function")
                {
                    callbackFunction(response.statusText);
                }
            }
        }
        catch(error)
        {
            if(typeof callbackFunction === "function")
            {
                callbackFunction(error);
            }
        }
    },


    getCookie : function(name)
    {
        const cookieValue = document.cookie
            .split('; ')
            .find(cookie => cookie.startsWith(name + '='))
            ?.split('=')[1];
        return cookieValue ? decodeURIComponent(cookieValue) : null;
    },


    fetchComponentData : function(url, elementID)
    {
        fetch(url,
        {
            method: 'GET',
            cache: "no-cache",
            mode: "no-cors",//cors, no-cors, same-origin
            credentials: "include"//include, same-origin, omit
        })
        .then(response =>
        {
            if(!response.ok)
            {
                throw new Error('Network response was not ok ' + response.statusText);
            }

            return response.json();
        })
        .then(data =>
        {
        alert(JSON.stringify(data));
            orionCommon.updateComponent(elementID, data);
        })
        .catch(error =>
        {
            document.getElementById(elementID).innerHTML = 'Failed to load data:' + error;
        });
    },


    updateComponent : function(elementID, data)
    {
        const element = document.getElementById(elementID);
        element.innerHTML = data;
    },


    connectToWebsocket : function(websocketURL, topicToSubscriberTo, reconnectAttempts, maxReconnectAttempts, reconnectDelay, reconnectTimer, callbackSuccessFunction)
    {
        let socket = new SockJS(websocketURL);
        let stompClient = Stomp.over(socket);
        stompClient.heartbeat.outgoing = 0;
        stompClient.heartbeat.incoming = 0;
        stompClient.reconnect_delay = 1000;

        //stompClient.connect({username: 'user', password: 'password'}, function(frame)
        stompClient.connect({}, function(frame)
        {
            console.log('Connected: ' + frame);
            reconnectAttempts = 0;
            stompClient.subscribe(topicToSubscriberTo, function(message)
            {
                if(message.body)
                {
                    let messageBody = JSON.parse(message.body);

                    if(callbackSuccessFunction)
                    {
                        callbackSuccessFunction(messageBody);
                    }
                }
            });
        },
        function(error) {
            console.log('Connection error:', error);
            orionCommon.handleWebsocketDisconnection(websocketURL, topicToSubscriberTo, reconnectAttempts, maxReconnectAttempts, reconnectDelay, reconnectTimer, callbackSuccessFunction);
        });

        return stompClient;
    },


    handleWebsocketDisconnection : function(websocketURL, topicToSubscriberTo, reconnectAttempts, maxReconnectAttempts, reconnectDelay, reconnectTimer, callbackSuccessFunction)
    {
        if(reconnectAttempts < maxReconnectAttempts)
        {
            console.log(`Connection lost. Attempting to reconnect in ${reconnectDelay/1000} seconds...`);

            if(reconnectTimer)
            {
                clearTimeout(reconnectTimer);
            }

            reconnectTimer = setTimeout(() => {
                reconnectAttempts++;
                console.log(`Reconnection attempt ${reconnectAttempts}/${maxReconnectAttempts}`);
                orionCommon.connectToWebsocket(websocketURL, topicToSubscriberTo, reconnectAttempts, maxReconnectAttempts, reconnectDelay, reconnectTimer, callbackSuccessFunction);
            }, reconnectDelay);
        }
        else
        {
            console.error('Max reconnection attempts reached. Please refresh the page.');
        }
    },


    loadComponent : async function(componentRelativePath, elementIDToInjectComponent)
    {
        try
        {
            const response = await fetch(componentRelativePath);
            const text = await response.text();
            const tempDiv = document.createElement('div');
            tempDiv.innerHTML = text;
            const template = tempDiv.querySelector('template');
            const clone = document.importNode(template.content, true);
            document.getElementById(elementIDToInjectComponent).appendChild(clone);
        }
        catch(error)
        {
            console.error('Error loading the component:', error);
        }
    }
};