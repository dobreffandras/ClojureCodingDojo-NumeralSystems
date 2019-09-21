(ns myproject.core 
	(:gen-class) 
	(:import [java.text ParseException SimpleDateFormat]))

(defn is-valid-language [lang] 
	(some true? [(= lang "Arabic") (= lang "Roman") (= lang "Urnfield")]))

(defn is-arabic [number-string] 
	(every? #(< -1 %) (map #(Character/digit % 10) (seq number-string))))

;;(defn is-roman [number-string] 
;;	(every? #(contains? ["I", "V", "X", "L", "C", "D", "M"] %) (seq number-string)))

;;(defn is-urnfield [number-string] 
;;	(every? #(contains? ["\", "/"] %) (seq number-string)))

(defn is-valid-number [number] 
	;;(some true? [(is-arabic number) (is-roman number) (is-urnfield number)])
	(some true? [(is-arabic number)])
	)

(defn valid-input [x] 
	(and 
		(= (count x) 3)
		(is-valid-language (first x))
		(is-valid-language (second x))
		(is-valid-number (nth x 2))
	))

(defn convert-number "Converts between numeral systems" 
	[from to number]
	(println "Convert the number " number " from " from " to " to))

(defn convert
	"Converts between numeral systems or throws exception if input is not valid"
	[arguments]
	(if (valid-input arguments)
		(let [[from to number] arguments]
			(convert-number from to number))
		(throw (ParseException. "Wrong input" 0))))

(defn -main [ & args ]
	(convert args))
