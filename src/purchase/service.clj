(ns purchase.service
  (:require [common.consumer :as consumer]
            [purchase.controller :as controller]))


(defn start []
  (println "Starting Purchase Service")
  (consumer/create "BANK_PURCHASE_CREATED" controller/purchase-created)
  (consumer/create "BANK_PURCHASE_HAS_LIMIT" controller/purchase-has-limit)
  (consumer/create "BANK_PURCHASE_NO_FRAUD" controller/purchase-no-fraud)
  (consumer/create "BANK_LIMIT_ALLOCATED" controller/limit-allocated))