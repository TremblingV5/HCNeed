import {Table} from "antd";

export function PositionList() {
  const columns = [
    {
      title: '职位标题',
      dataIndex: 'title',
      key: 'title'
    },
    {
      title: '所属公司',
      dataIndex: 'company',
      key: 'company'
    },
    {
      title: '工作地点',
      dataIndex: 'location',
      key: 'location'
    }
  ];
  return (
    <div className="position_list">
      <Table
        columns={columns}
      />
    </div>
  );
}