from crawl_templates import feishu


class Bytedance(feishu.FeiShuCrawler):
    BASE_URL = "https://job.bytedance.com"

    def __init__(self):
        super().__init__()
