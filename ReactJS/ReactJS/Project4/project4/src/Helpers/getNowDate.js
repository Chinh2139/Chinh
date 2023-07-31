export function getNowDate(props) {
    let date = new Date();
    // lấy ra ngày hiện tại
    let currentDay = date.getDate();
    //  lấy ra tháng hiện tại
    let currentMonth = date.getMonth();
    // lấy ra năm hiện tại
    let currentYear = date.getFullYear();

    return currentYear + "-" + currentMonth + "-" + currentDay;
}