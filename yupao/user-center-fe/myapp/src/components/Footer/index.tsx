import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import React from 'react';

const Footer: React.FC = () => {
  return (
    <DefaultFooter
      style={{
        background: 'none',
      }}
      links={[
        {
          key: 'you',
          title: 'YouTuBe',
          href: 'https://www.youtube.com/',
          blankTarget: true,
        },
        {
          key: 'blibli',
          title: 'Blibli',
          href: 'https://www.bilibili.com/',
          blankTarget: true,
        },
        {
          key: 'youdao',
          title: 'Youdao',
          href: 'https://fanyi.youdao.com/#/AITranslate',
          blankTarget: true,
        },
      ]}
    />
  );
};

export default Footer;
