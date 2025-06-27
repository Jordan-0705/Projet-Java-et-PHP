function showPage(pageId) {
    document.querySelectorAll('.page').forEach(page => page.classList.remove('active'));
    document.querySelectorAll('.sidebar ul li').forEach(tab => tab.classList.remove('active'));
    document.getElementById(pageId).classList.add('active');
    document.querySelector(`.sidebar ul li[onclick="showPage('${pageId}')"]`).classList.add('active');
}

