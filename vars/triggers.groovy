def jobName = "my-job" // replace with your job name
def job = Jenkins.instance.getItem(jobName)

// Poll SCM trigger
def scmTriggerSpec = "H * * * *" // every hour
job.addTrigger(new SCMTrigger(scmTriggerSpec))

// Timer trigger
def timerTriggerSpec = "0 0 * * *" // midnight every day
job.addTrigger(new TimerTrigger(timerTriggerSpec))

// Build periodically trigger
def buildPeriodicallyTriggerSpec = "@weekly"
job.addTrigger(new TimerTrigger(buildPeriodicallyTriggerSpec))

// GitHub webhook trigger
def githubRepoUrl = "https://github.com/my-username/my-repo" // replace with your GitHub repository URL
def githubWebhookTrigger = new GithubWebhookTrigger(githubRepoUrl)
job.addTrigger(githubWebhookTrigger)

// Pull request trigger
def pullRequestTrigger = new PullRequestTrigger()
job.addTrigger(pullRequestTrigger)

// Bitbucket webhook trigger
def bitbucketRepoUrl = "https://bitbucket.org/my-username/my-repo" // replace with your Bitbucket repository URL
def bitbucketWebhookTrigger = new BitbucketWebhookTrigger(bitbucketRepoUrl)
job.addTrigger(bitbucketWebhookTrigger)

// Jenkinsfile webhook trigger
def jenkinsfileWebhookTrigger = new JenkinsfileWebhookTrigger()
job.addTrigger(jenkinsfileWebhookTrigger)

// Cron trigger
def cronTriggerSpec = "0 0 * * *"
job.addTrigger(new CronTrigger(cronTriggerSpec))

// Pipeline trigger
def pipelineTrigger = new PipelineTrigger()
job.addTrigger(pipelineTrigger)

// Multi-branch pipeline trigger
def multiBranchPipelineTrigger = new BranchIndexingTrigger()
job.addTrigger(multiBranchPipelineTrigger)

// GitHub pull request builder trigger
def githubPullRequestBuilderTrigger = new GithubPullRequestBuilderTrigger()
job.addTrigger(githubPullRequestBuilderTrigger)

// Parameterized trigger
def parameterizedTrigger = new hudson.plugins.parameterizedtrigger.TriggerBuilder(
    new hudson.plugins.parameterizedtrigger.BuildTrigger(
        "my-trigger-job", // replace with your trigger job name
        "SUCCESS",
        new hudson.plugins.parameterizedtrigger.PredefinedParameters(
            "param1=value1\nparam2=value2"
        ),
        new hudson.plugins.parameterizedtrigger.TriggerBuilder(
            new hudson.plugins.parameterizedtrigger.BuildTrigger(
                "my-second-trigger-job", // replace with your second trigger job name
                "SUCCESS"
            )
        )
    )
)
job.addTrigger(parameterizedTrigger)

// Remote trigger
def remoteTrigger = new RemoteTrigger()
job.addTrigger(remoteTrigger)
