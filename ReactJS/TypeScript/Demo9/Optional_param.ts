// Biến không bắt buộc, có thể có hoặc không
function Hello(id: number, name: string, mail?: string) {
  console.log("ID: " + id);
  console.log("Name: " + name);
  if (mail != undefined) {
    console.log("Mail: " + mail);
  }
}
Hello(1, "nam", "namamfakn@gmail.com");
Hello(2, "bac");
