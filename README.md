# Play 2.5 Filter performance downgrade

This is the example project for reproducing play 2.5 filter performance downgrade

### Running

Sbt comes prepackaged with the project, just download the project and create a distribution package using:-

```
sbt dist
```

### Problem

Create a distribution package and uploaded it to AWS EC2 c3.xlarge machine and unzip it. You can start the service by running the script in bin directory. Load test /status API with and without Filters enabled. Filters can be enabled/disabled in application.conf just comment the filter configuration to disable it.

Performance:-

Filters Disabled: 34K req/sec

Filters Enabled:  19K req/sec

FYI: JMeter was used to load test from an external machine on AWS EC2.

### Logs

#### Filters disabled

```
summary +   1651 in     2s = 1071.4/s Avg:     1 Min:     1 Max:   297 Err:     0 (0.00%) Active: 3 Started: 4 Finished: 1
summary + 733753 in    30s = 24459.2/s Avg:     1 Min:     0 Max:   205 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 735404 in    32s = 23315.8/s Avg:     1 Min:     0 Max:   297 Err:     0 (0.00%)
summary + 1034238 in    30s = 34474.6/s Avg:     1 Min:     0 Max:   207 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 1769642 in    62s = 28755.5/s Avg:     1 Min:     0 Max:   297 Err:     0 (0.00%)
summary + 1006306 in    30s = 33543.5/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 2775948 in    92s = 30324.6/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%)
summary + 1030124 in    30s = 34337.5/s Avg:     1 Min:     0 Max:   206 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 3806072 in   122s = 31315.1/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%)
summary + 1029997 in    30s = 34333.2/s Avg:     1 Min:     0 Max:   208 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 4836069 in   152s = 31912.6/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%)
summary + 1031452 in    30s = 34380.6/s Avg:     1 Min:     0 Max:   207 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 5867521 in   182s = 32320.5/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%)
summary + 1029368 in    30s = 34313.4/s Avg:     1 Min:     0 Max:   206 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 6896889 in   212s = 32603.1/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%)
summary + 1029025 in    30s = 34300.8/s Avg:     1 Min:     0 Max:   210 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 7925914 in   242s = 32813.9/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%)
summary + 1028904 in    30s = 34296.8/s Avg:     1 Min:     0 Max:   207 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 8954818 in   272s = 32977.8/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%)
summary + 1029919 in    30s = 34330.6/s Avg:     1 Min:     0 Max:   206 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 9984737 in   302s = 33112.4/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%)
summary + 1027420 in    30s = 34247.3/s Avg:     1 Min:     0 Max:   209 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 11012157 in   332s = 33215.1/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%)
summary + 1029843 in    30s = 34328.1/s Avg:     1 Min:     0 Max:   406 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 12042000 in   362s = 33307.4/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%)
summary + 1027870 in    30s = 34262.3/s Avg:     1 Min:     0 Max:   207 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 13069870 in   392s = 33380.6/s Avg:     1 Min:     0 Max:   732 Err:     0 (0.00%)
```
#### Filters enabled
```
summary + 135732 in    14s = 9662.7/s Avg:     1 Min:     0 Max:   294 Err:     0 (0.00%) Active: 26 Started: 27 Finished: 1
summary + 587621 in    30s = 19587.4/s Avg:     2 Min:     0 Max:   208 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 723353 in    44s = 16422.3/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 601741 in    30s = 20058.0/s Avg:     2 Min:     0 Max:   217 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 1325094 in    74s = 17895.3/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 601320 in    30s = 20044.0/s Avg:     2 Min:     0 Max:   211 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 1926414 in   104s = 18514.8/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 600536 in    30s = 20017.9/s Avg:     2 Min:     0 Max:   211 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 2526950 in   134s = 18851.2/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 599911 in    30s = 19997.0/s Avg:     2 Min:     0 Max:   208 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 3126861 in   164s = 19060.8/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 600168 in    30s = 20005.6/s Avg:     2 Min:     0 Max:   211 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 3727029 in   194s = 19206.8/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 596410 in    30s = 19880.3/s Avg:     2 Min:     0 Max:   212 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 4323439 in   224s = 19297.0/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 601367 in    30s = 20045.6/s Avg:     2 Min:     0 Max:   212 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 4924806 in   254s = 19385.4/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 594185 in    30s = 19806.2/s Avg:     2 Min:     0 Max:   208 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 5518991 in   284s = 19429.9/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 590635 in    30s = 19687.8/s Avg:     2 Min:     0 Max:   213 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 6109626 in   314s = 19454.5/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 591221 in    30s = 19707.4/s Avg:     2 Min:     0 Max:   209 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 6700847 in   344s = 19476.5/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 590285 in    30s = 19676.2/s Avg:     2 Min:     0 Max:   209 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 7291132 in   374s = 19492.6/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 595010 in    30s = 19833.7/s Avg:     2 Min:     0 Max:   210 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 7886142 in   404s = 19517.9/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 597254 in    30s = 19908.5/s Avg:     2 Min:     0 Max:   210 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 8483396 in   434s = 19544.9/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 595089 in    30s = 19836.3/s Avg:     2 Min:     0 Max:   209 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 9078485 in   464s = 19563.7/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 592648 in    30s = 19754.9/s Avg:     2 Min:     0 Max:   211 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 9671133 in   494s = 19575.3/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 595595 in    30s = 19853.2/s Avg:     2 Min:     0 Max:   209 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 10266728 in   524s = 19591.2/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 595129 in    30s = 19837.6/s Avg:     2 Min:     0 Max:   208 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 10861857 in   554s = 19604.6/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
summary + 595922 in    30s = 19864.1/s Avg:     2 Min:     0 Max:   211 Err:     0 (0.00%) Active: 55 Started: 56 Finished: 1
summary = 11457779 in   584s = 19617.9/s Avg:     2 Min:     0 Max:   294 Err:     0 (0.00%)
```