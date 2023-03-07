import {Table} from 'antd';
import {useState} from "react";


const columns = [
    {
        title: 'Id',
        dataIndex: 'id',
        key: 'id',
    },
    {
        title: 'Departure',
        dataIndex: 'departureCity',
        key: 'departureCity',
    },
    {
        title: 'Available weight',
        dataIndex: 'weightAvalaible',
        key: 'weightAvalaible',
    },
    {
        title: 'Price per Kg',
        dataIndex: 'price',
        key: 'price',
    },
    {
        title: 'Action',
        dataIndex: '',
        key: 'x',
        render: () => <a>Delete</a>,
    },
];
export const FlightTable = ({flights}) => (
    <Table
        columns={columns}
        expandable={{
            expandedRowRender: (record) => (
                <p
                    style={{
                        margin: 0,
                    }}
                >
                    {record.description}
                </p>
            ),
            rowExpandable: (record) => record.name !== 'Not Expandable',
        }}
        dataSource={flights}
    />
);
