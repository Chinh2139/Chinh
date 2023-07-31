import React from 'react';
import { Button, Container } from 'reactstrap';

function Survey(props) {
    return (
        <Container>
            <h2 style={{ color: "green", textAlign: "center" }}>Khảo sát thói quen sử dụng Tivi của người tiêu dùng Việt Nam</h2>
            <div>
                <h3>1. bạn bao nhiêu tuổi: </h3>
                <input type='checkbox' />A: dưới 25 tuổi<br></br>
                <input type='checkbox' />B: dưới 25 tuổi<br></br>
                <input type='checkbox' />C: dưới 25 tuổi<br></br>
                <input type='checkbox' />D: dưới 25 tuổi<br></br>
            </div>

            <div>
                <h3>2. Tivi mà bạn mua đã sử dụng được bao lâu rồi?: </h3>
                <input type='checkbox' />A、1-3 Năm <br></br>
                <input type='checkbox' />B、4-6 Năm <br></br>
                <input type='checkbox' />C: trên 6 Năm<br></br>
            </div>

            <div>
                <h3>3. Bao lâu bạn đổi 1 chiếc Tivi?: </h3>
                <input type='checkbox' />A、1-3 Năm <br></br>
                <input type='checkbox' />B、4-6 Năm <br></br>
                <input type='checkbox' />C: trên 6 Năm<br></br>
            </div>
            <div>
                <h3>4. Thời hạn bảo hành Tivi của bạn là bao lâu?: </h3>
                <input type='checkbox' />A、1 Năm <br></br>
                <input type='checkbox' />B、2 Năm <br></br>
                <input type='checkbox' />C: 3 Năm<br></br>
                <input type='checkbox' />D: trên 3 Năm<br></br>
            </div>
            <div>
                <h3>5. Bạn thường xem phim,video bằng gì?: </h3>
                <input type='checkbox' />A、Truyền hình cáp  <br></br>
                <input type='checkbox' />B、Set-top box <br></br>
                <input type='checkbox' />C、Smart Tivi<br></br>
                <input type='checkbox' />D、Điện thoại,máy tính hoặc các thiết bị khác<br></br>
            </div>
            <Button color='success' style={{ marginLeft: "40%" }}>
                Done
            </Button>
        </Container>
    );
}

export default Survey;