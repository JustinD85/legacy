(ns base-control.core
  (:gen-class)
  (:require [clojure.java.jdbc :as j]))

(def db {
         :class-name "mysql-connector-java-8.0.13"
         :subprotocol "mysql"
         :subname "//localhost:3306/test_schema"
         :user "root"
         :password "@@22WWww"
         })
;;(j/insert-multi! db :user
;;                [{:username "bob" :password "builder" :email "muhemail"}])
;;(println (j/query db ["select * from user"] {:row-fn :password}))

(def card-table-ddl
  (j/create-table-ddl :cards
                      [
                       [:id :int "PRIMARY KEY" "AUTO_INCREMENT"]
                       [:name "varchar(32)"]
                          [:cost :int]
                          [:str :int]
                          [:move :int]
                          [:reach :int]
                          [:def :int]
                          [:life :int]]))

(defn addCard [name cost str move reach def life] 
  ;;(j/db-do-commands db [card-table-ddl] )
  (j/insert! db :cards {:name name
                       :cost cost
                       :str str
                       :move move
                       :reach reach
                       :def def
                       :life life}))

;;(j/insert! db :fruits {:name "hm"})
(defn getCards []
(j/query db "select * from cards as result" ))

"select * from cards where card.id === 3"
;.select('cards').where('card.id === 3')


