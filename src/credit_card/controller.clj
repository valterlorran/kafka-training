(ns credit-card.controller
  (:require [common.producer :as producer]))

(defn verify-limit
  [key data]
  (println "verify-limit" key data)
  (producer/produce! (producer/create-topic "BANK_PURCHASE_HAS_LIMIT")
                     (str key "-verify-limit" )
                     data))

(defn allocate-limit
  [key data]
  (println "allocate limit" key data)
  (producer/produce! (producer/create-topic "BANK_LIMIT_ALLOCATED")
                     (str key "-allocate-limit" )
                     data))