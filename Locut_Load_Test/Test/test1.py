from locust import HttpUser, between, task

class BaykarKariyerUser(HttpUser):
    wait_time = between(5, 15)
    base_url = "http://kariyer.baykartech.com"

    @task
    def browse_jobs(self):
        self.client.get("/jobs", base_url=self.base_url)

    @task
    def view_job_details(self):
        job_id = "test"
        self.client.get(f"/jobs/{job_id}", base_url=self.base_url)

    @task
    def search_jobs(self):
        params = {"keyword": "software engineer", "location": "istanbul"}
        self.client.get("/jobs", params=params, base_url=self.base_url)

    @task
    def apply_to_job(self):
        job_id = "test"
        self.client.post(f"/jobs/{job_id}/apply", json={"name": "John Doe", "email": "john@example.com", "resume": "path/to/resume.pdf"}, base_url=self.base_url)
