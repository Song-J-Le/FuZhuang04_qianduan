$(function () {
    findAll();
})

function findAll() {
    $.ajax({
        url: '/home',
        data: {newsWhereShow: 1},
        type: 'get',
        dataType: 'json',
        success: function (res) {
            console.log(res);
            // res[0]
            // setCompanyData(res.companyModel);
            // setNavData(res.navModelList);
            setNewsData(res.newsModelList);
        }
    })
}

// 新闻赋值
function setNewsData(data) {
    let html = '';
    for (let i = 0; i < data.length; i++) {
        html += '<div>\n' +
            '                            <div onclick="gotoNewsDetailPage(' + data[i].id + ')">' + data[i].title + '\n' +
            '                            </div>\n' +
            '                            <div>' + data[i].content + '</div>\n' +
            '                        </div>';
    }
    $("#news").html(html);
}

function gotoNewsDetailPage(id) {
    sessionStorage.setItem("newsId", id);
    window.open('/html/news-detail.html', '_self');
}