import React from 'react';
import { Container, Table } from "reactstrap";
import ResultFormItem from './ResultFormItem';
function ResultForm(props) {
    return (
        <Container>
            <Table
                bordered
                borderless
                dark
                hover
                responsive
                striped
            >
                <thead>
                    <tr>
                        <th>
                            ID
                        </th>
                        <th>
                            Customer Name
                        </th>
                        <th>
                            Email
                        </th>
                        <th>
                            UserName
                        </th>
                        <th>
                            FullName
                        </th>
                        <th>
                            Mobie
                        </th>
                        <th>
                            Address
                        </th>
                        <th>
                            CreateDate
                        </th>

                    </tr>
                </thead>
                <tbody>
                    <ResultFormItem />

                </tbody>
            </Table>
        </Container>

    );
}

export default ResultForm;