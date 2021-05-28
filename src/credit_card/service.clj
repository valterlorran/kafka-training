(ns credit-card.service
  (:require [common.consumer :as consumer]
            [credit-card.controller :as controller]))


(defn start []
  (println "Starting Credit Card Service")
  (consumer/create "BANK_CREDIT_CARD_VERIFY_LIMIT" controller/verify-limit)
  (consumer/create "BANK_CREDIT_CARD_ALLOCATE_LIMIT" controller/allocate-limit))