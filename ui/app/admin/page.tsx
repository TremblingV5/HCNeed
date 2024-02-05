import Layout from "antd/es/layout/layout";
import Sider from "antd/es/layout/Sider";
import {Menu} from "antd";

export default function Admin() {
  const items = [
    { label: "1" },
    { label: "2" },
    { label: "3" }
  ];

  return (
    <div className="admin">
      <Layout>
        <Sider>
          <Menu
            items={items}
          />
        </Sider>
      </Layout>
    </div>
  );
};