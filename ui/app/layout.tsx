import type { Metadata } from 'next'
import { Inter } from 'next/font/google'
import {AntdRegistry} from "@ant-design/nextjs-registry";
import {PageHeader} from "@/components/PageHeader/PageHeader";
import {PageFooter} from "@/components/PageFooter/PageFooter";
import React from "react";
import {Flex} from "antd";
import Layout, {Content} from "antd/es/layout/layout";
import './globals.css'

const inter = Inter({ subsets: ['latin'] })

export const metadata: Metadata = {
  title: 'HC Need',
  description: 'I need a head count',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <div className="App">
          <Flex gap="middle" wrap="wrap" className="flex">
            <Layout>
              <PageHeader />
              <AntdRegistry>
                <Content>
                  <div className="content">
                    {children}
                  </div>
                </Content>
              </AntdRegistry>
              <PageFooter />
            </Layout>
          </Flex>
        </div>
      </body>
    </html>
  )
}
