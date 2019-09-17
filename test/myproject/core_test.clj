(ns myproject.core-test
	(:require 
		[clojure.test :refer :all]
		[myproject.core :refer :all])
	(:import 
		[java.text ParseException SimpleDateFormat]))

(deftest invalid-input
	(testing "Converter throws exception for invalid input"
		(is (thrown? ParseException (convert ["asd"]))
			"Too few arguments")
		(is (thrown? ParseException (convert ["Arabic" "Roman" "Urnfield" "asd"]))
			"Too many Arguments")
		(is (thrown? ParseException (convert ["Arabic" "Roman" "asd"]))
			"Not Arabic input")
		(is (thrown? ParseException (convert ["Roman" "Arabic" "asd"]))
			"Not Roman input")
		(is (thrown? ParseException (convert ["Urnfield" "Roman" "asd"]))
			"Not Urnfield input")
		(is (thrown? ParseException (convert ["a" "Roman" "asd"]))
			"First parameter is not one of the three possible systems")
		(is (thrown? ParseException (convert ["Roman" "a" "asd"]))
			"Second parameter is not one of the three possible systems")
	))

(deftest arabic-to-roman
	(testing "Converter converts Arabic to Roman Correctly"
		(is (= "I" (convert ["Arabic" "Roman" "1"])))
		(is (= "II" (convert ["Arabic" "Roman" "2"])))
		(is (= "III" (convert ["Arabic" "Roman" "3"])))
		(is (= "IV" (convert ["Arabic" "Roman" "4"])))
		(is (= "V" (convert ["Arabic" "Roman" "5"])))
		(is (= "VI" (convert ["Arabic" "Roman" "6"])))
		(is (= "VIII" (convert ["Arabic" "Roman" "7"])))
		(is (= "IX" (convert ["Arabic" "Roman" "9"])))
		(is (= "X" (convert ["Arabic" "Roman" "10"])))
		(is (= "XI" (convert ["Arabic" "Roman" "11"])))
		(is (= "XII" (convert ["Arabic" "Roman" "12"])))
		(is (= "XIV" (convert ["Arabic" "Roman" "14"])))
		(is (= "XV" (convert ["Arabic" "Roman" "15"])))
		(is (= "XIX" (convert ["Arabic" "Roman" "19"])))
		(is (= "XXX" (convert ["Arabic" "Roman" "30"])))
		(is (= "XL" (convert ["Arabic" "Roman" "40"])))
		(is (= "XLIX" (convert ["Arabic" "Roman" "49"])))
		(is (= "XCIX" (convert ["Arabic" "Roman" "99"])))
		(is (= "CLXVIII" (convert ["Arabic" "Roman" "168"])))
	))