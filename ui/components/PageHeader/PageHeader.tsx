import React from "react";
import {Header} from "antd/es/layout/layout";
import {Avatar, Menu} from "antd";
import {UserOutlined} from "@ant-design/icons";
import Link from "next/link";

import "./PageHeader.css"

export interface PageHeaderProps {
  userType: "ADMIN" | "USER";
}

export function PageHeader(props: PageHeaderProps) {
  const { userType } = props;

  const items = [
    { label: (<Link href="/">首页</Link>) },
    { label: (<Link href="/company">公司列表</Link>) },
    { label: (<Link href="/position">职位列表</Link>) },
    { label: (<Link href="/forum">求职论坛</Link>) },
    { label: (<Link href="/admin">平台管理</Link>) },
  ];

  return (
    <Header>
      <Menu
        theme="dark"
        mode="horizontal"
        items={items}
      />
      <Avatar icon={<UserOutlined />} />
    </Header>
  );
};