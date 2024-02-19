import {Table} from "antd";

export function CompanyList() {
  const columns = [
    {
      title: '公司名称',
      dataIndex: 'name',
      key: 'name'
    },
    {
      title: '招聘网站地址',
      dataIndex: 'url',
      key: 'url'
    }
  ];
  return (
    <div className="company_list">
      <Table
        columns={columns}
      />
    </div>
  );
}