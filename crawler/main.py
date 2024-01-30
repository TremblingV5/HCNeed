from fastapi import FastAPI
from concurrent.futures import ThreadPoolExecutor
import time
import asyncio
from tasks.bytedance import Bytedance


app = FastAPI()
executor = ThreadPoolExecutor(max_workers=2) 

def test():
    print("start")
    time.sleep(5)
    print("end")

@app.get("/")
async def index():
    loop = asyncio.get_event_loop()
    loop.run_in_executor(executor, test)
    return "result"

# 查询所有任务的列表
@app.get("/list")
async def list():
    return ""

# 根据任务id查询某一任务的执行情况
@app.get("/detail/{id}")
async def detail(id: int):
    return ""

# 触发某一模板
@app.post("/run/{crawlerName}")
async def run(crawlerName: str):
    return ""

if __name__ == "__main__":
    crawler = Bytedance()
    print(crawler.crawl())
