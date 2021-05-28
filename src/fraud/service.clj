(ns fraud.service
  (:require [common.consumer :as consumer]
            [fraud.controller :as controller]))


(defn start []
  (println "Starting Fraud Service")
  (consumer/create "BANK_FRAUD_VERIFY" controller/fraud-verify))