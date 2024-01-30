import requests


class FeiShuCrawler:
    
    BASE_URL = ""
    SESSION = requests.Session()
    
    def __init__(self):
        pass
        
    def csrf(self):
        csrf_url = f"{self.BASE_URL}/api/v1/csrf/token"
        return self.SESSION.post(csrf_url).json()["data"]["token"]

    def crawl(self):
        token = self.csrf()
        headers = {
            "x-csrf-token": token,
        }
        postData = '{"keyword":"","limit":999,"offset":0,"job_category_id_list":[],"tag_id_list":[],"location_code_list":[],"subject_id_list":[],"recruitment_id_list":[],"portal_type":2,"job_function_id_list":[],"portal_entrance":1}'
        job_list_url = f"{self.BASE_URL}/api/v1/search/job/posts"
        return self.SESSION.post(job_list_url, headers=headers, data=postData).json()
