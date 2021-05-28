(ns purchase.controller
  (:require [common.producer :as producer])
  (:import ))

(defn purchase-created [key data]
  (println "created" key data)
  (producer/produce! (producer/create-topic "BANK_CREDIT_CARD_VERIFY_LIMIT")
                     (str key "-purchase-created" )
                     data))

(defn purchase-has-limit [key data]
  (println "has limit" key data)
  (producer/produce! (producer/create-topic "BANK_FRAUD_VERIFY")
                     (str key "-purchase-has-limit" )
                     data))

(defn purchase-no-fraud [key data]
  (println "no-fraud" key data)
  (producer/produce! (producer/create-topic "BANK_CREDIT_CARD_ALLOCATE_LIMIT")
                     (str key "-purchase-no-fraud" )
                     data))

(defn limit-allocated [key data]
  (println "limit-allocated" key data))