# metosin-api

A [clj-new](https://github.com/seancorfield/clj-new) template for building
content-negotiated http services based on the libraries from
[Metosin](https://github.com/metosin).

Specifically, the following libs are used as a basis for building fast,
data-driven http services with opinionated configurations:

* [reitit](https://github.com/metosin/reitit) - routing
* [malli](https://github.com/metosin/malli) - schemas
* [muuntaja](https://github.com/metosin/muuntaja) - content negotiation
* [jsonista](https://github.com/metosin/jsonista) - fast json [en|de]coding

## Using this template

After having installed
[clj-new](https://github.com/seancorfield/clj-new) and assuming you
setup a `:new` alias you can make use of this template by running
the command:

```
clj -X:new :template metosin-api :name package-name/app-name
Generating a project called http-service based on the "metosin-api" template.
```

Then you can do:

```
$ tree mylibname/
mylibname/
├── deps.edn
├── src
│   └── packagename
│       └── app_name.clj
└── test
    └── packagename
        └── app_name_test.clj

6 directories, 5 files
```

## Development

If you're working on the lib itself you can have it generate a new
template from the project root directory with the command:

Run: `clj -m clj-new.create metosin-api myname/mynewlib` to test

## License

Copyright Stephen Caudill © 2020

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
