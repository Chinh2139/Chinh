import React from 'react';
import { UncontrolledCarousel } from "reactstrap";

function Banner(props) {
    return (
        <div>
            <UncontrolledCarousel style={{ width: "600px", height: "400px" }}
                items={[
                    {
                        key: 1,
                        src: 'Asset/uploadImage/banner1.png'
                    },
                    {
                        key: 2,
                        src: 'Asset/uploadImage/banner2.png'
                    },
                    {
                        key: 3,
                        src: 'Asset/uploadImage/banner3.png'
                    },
                    {
                        key: 4,
                        src: 'Asset/uploadImage/banner4.png'
                    },
                    {
                        key: 5,
                        src: 'Asset/uploadImage/banner5.png'
                    },
                    {
                        key: 6,
                        src: 'Asset/uploadImage/banner6.png'
                    },
                    {
                        key: 7,
                        src: 'Asset/uploadImage/banner7.png'
                    }
                ]}
            />
        </div>
    );
}

export default Banner;