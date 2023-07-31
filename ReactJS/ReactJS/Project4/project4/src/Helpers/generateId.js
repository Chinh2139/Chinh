export function generateID() {
    let idStart = 0;
    // Kiểm tra xem có dữ liệu trong localStorage chưa, nếu có thì lấy giá trị lớn nhất của id
    // trong listAccount để làm id bắt đầu
    if (localStorage && localStorage.getItem("listAccount")) {
        let listAccount = JSON.parse(localStorage.getItem("listAccount"));
        listAccount.forEach((account) => {
            if (account.id > idStart) {
                idStart = account.id;
            }
        });
    }
    let id = idStart + 1;
    return id;
}