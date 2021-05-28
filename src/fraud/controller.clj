(ns fraud.controller
  (:require [common.producer :as producer]
            [fraud.logic :as logic]))

(defn fraud-verify [key data]
  (println "fraud-verify" key data)
  (println "is fraud" (:merchant data))
  (producer/produce! (producer/create-topic "BANK_PURCHASE_NO_FRAUD")
                     (str key "-fraud-verify" )
                     data))