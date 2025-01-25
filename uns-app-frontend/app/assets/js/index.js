window.onload = async function () {
    const componentPromises = [
        orionCommon.loadComponent('imports/HTMLHeader.html', 'html-header'),
        orionCommon.loadComponent('imports/header.html', 'header'),
        orionCommon.loadComponent('imports/sidebar.html', 'sidebar')
    ];

    await Promise.all(componentPromises);
    App.init();
};


$(document).ready(function()
{
    orionCommon.makeGetAJAXCall('http://localhost:8080/api/v1/system/version', indexPage.showSystemVersion);
});


var indexPage =
{
    showSystemVersion : function(response)
    {
        orionCommon.updateComponent('system-version-val', response.version);
    }
};