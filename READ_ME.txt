Project:-
WebCrawler

Description:- 
Application is build on Spring Boot. It takes an input request,
process it and returns response. Input request file is given in resource folder, named "internet_1.json"
 
How to run:-
com.GE.WebCrawler.Controller.WebServiceApplication class is the initial point to run the application.

 
Sample request:

{
  "pages":[
    {
      "address":"page-01",
      "links":[
        "page-02",
        "page-03"
      ]
    },
    {
      "address":"page-02",
      "links":[
        "page-01"
      ]
    },
    {
      "address":"page-03",
      "links":[
        "page-01",
        "page-02",
        "page-04"
      ]
    },
    {
      "address":"page-04",
      "links":[
        "page-01",
        "page-02",
        "page-03",
        "page-05"
      ]
    },
    {
      "address":"page-05",
      "links":[
        "page-01",
        "page-02",
        "page-06",
        "page-09"
      ]
    },
    {
      "address":"page-06",
      "links":[
        "page-07",
        "page-08"
      ]
    },
    {
      "address":"page-07",
      "links":[
        "page-05",
        "page-08",
        "page-09",
        "page-10"
      ]
    },
    {
      "address":"page-08",
      "links":[
        "page-09",
        "page-00"
      ]
    },
    {
      "address":"page-09",
      "links":[
        "page-10",
        "page-11",
        "page-12",
        "page-13",
        "page-99"
      ]
    },
    {
      "address":"page-96",
      "links":[
        "page-01",
        "page-97"
      ]
    },
    {
      "address":"page-97",
      "links":[
        "page-98"
      ]
    },
    {
      "address":"page-98",
      "links":[
        "page-99"
      ]
    },
    {
      "address":"page-99",
      "links":[
        "page-01",
        "page-02",
        "page-03",
        "page-04"
      ]
    }
  ]
}


Sample Response:

{"Success":[
   "page-99",
   "page-01",
   "page-04",
   "page-05",
   "page-02",
   "page-03",
   "page-08",
   "page-09",
   "page-06",
   "page-07"]
 "Skipped":[
    "page-01",
    "page-10",
    "page-04",
    "page-05",
    "page-02",
    "page-03",
    "page-08",
    "page-09"]
 "Error":[
    "page-11",
    "page-00",
    "page-12",
    "page-10",
    "page-13"]
}    