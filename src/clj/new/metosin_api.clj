(ns clj.new.metosin-api
  (:require [clj.new.templates :as t]))

(def render )

(defn metosin-api
  "Create a clojure template for HTTP APIs based on the metosin family of libraries"
  [name & args]
  (let [render (t/renderer "metosin-api")
        data (merge {:description "FIXME: my new http service."}
                    (t/project-data name))]
    (println "Generating a project called"
             (t/project-name name)
             "based on the \"metosin-api\" template.")
    (t/->files data
             ["deps.edn" (render "deps.edn" data)]
             ["README.md" (render "README.md" data)]
             ["doc/intro.md" (render "intro.md" data)]
             [".gitignore" (render "gitignore" data)]
             [".hgignore" (render "hgignore" data)]
             ["src/{{nested-dirs}}.clj" (render "namespace.clj" data)]
             ["test/{{nested-dirs}}_test.clj" (render "test.clj" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["CHANGELOG.md" (render "CHANGELOG.md" data)]
             ["pom.xml" (render "pom.xml" data)]
             ["resources/.keep" ""])))
