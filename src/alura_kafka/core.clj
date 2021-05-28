(ns alura-kafka.core
  (:require
    [purchase.service :as purchase-service]
    [credit-card.service :as credit-card-service]
    [fraud.service :as fraud-service]
    [log.service :as log-service]
    [alura-kafka.test :as ak-test]))


(purchase-service/start)
(credit-card-service/start)
(fraud-service/start)
(log-service/start)

(ak-test/run-tests)