$(function () {
    common();
})

function common() {
    $.ajax({
        url: '/common',
        data: {},
        type: 'get',
        dataType: 'json',
        success: function (res) {
            console.log(res);
            setCompanyData(res.companyModel);
            setNavData(res.navModelList);
        }
    })
}

function setCompanyData(data) {

    $("#logo").attr("src", data.logo);
    $("#phone").html(data.phone);
    $("#net").html("网址: " + data.net);
    $("#email").html("邮箱:" + data.email + "联系电话: " + data.linePhone + "(座机)");
    $("#address").html("联系地址：" + data.address);
    $("#version").html(data.version);

}

// 对导航赋值
function setNavData(data) {
    let html = '';
    for (let i = 0; i < data.length; i++) {
        html += '<div onclick="window.open(\'' + data[i].href + '\')"><a href="#">' + data[i].title + '</a></div>';
    }
    $("#nav").html(html);
}

