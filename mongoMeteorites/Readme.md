## Process of creation of a REST API
REST APIs are one of the backbones of any application using data. They work as a interface where we can interact with data, allowing us to read, write, update or delete data form a database without having to interact with the database itself. In this project
we will see the process of how to contruct a REST API from the very beggining: The data itself.

### The data
#### Choosing a database

Any data that our REST API is going to interact with is going to be located in some kind of database. There are many different kinds of database, each with their strenghts and weakneness and we can mainly divide databases in 2 different groups: Relational
and non-relational databases. For this project we will focus in one of the most popular non-relational databases outr there: [MongoDB](https://www.mongodb.com/es).
#### MongoDB

[MongoDB](https://www.mongodb.com/es) is a database thag uses JSON documents to hold the data. As i said earlier, it is non-relational, so we won't need to relate our data with primary keys and foreign keys and all that stuff. 
To host out MongoDB database, we will use a [Docker](https://www.docker.com/) container. 
The first step is going to be to download the official MongoDB image from Docker desktop (or you can download it by other means) and spin up the container.

In this case, I made it so the container is accessible via port 7777, but you can choose any port you want. You will also need to set a user and password for the MongoDB database. Learn how to do all that by reading the [Docker documentation](https://docs.docker.com/).

Once spun up, we can use [Compass](https://www.mongodb.com/products/tools/compass), MongoDB's official client, to access our database and start importing data.

#### Working with datasets

Datasets are, as the name implies, sets of preloaded data. We will use one of this datasets to quickly have something our REST API can access. There are a lot of datasets available publicaly, but in this case I will be using a [meteorite landing](https://github.com/jdorfman/awesome-json-datasets?tab=readme-ov-file#nasa) dataset from a list of very good datasets compiled by user [jdorfman](ttps://github.com/jdorfman) in github. This dataset contains data from all known meteorite impacts on earth and it includes things like coordenates and meteorite mass. To import this dataset into MongoDB we will first create a new database and collection within Compass and then, using the "Add data" button, we will select the downloaded file and import it. This will create our database. In this case I didn't have to do anything to the data, but in other cases you might need to adecuate your data using MongoSH, MongoDB's built in shell. You can learn more about it [here](https://www.mongodb.com/docs/mongodb-shell/).

### The API

Once we have our databse ready, we will create our REST API. We will be using (Spring)[https://spring.io/] to build this REST API, one of the most popular ways to build this kinds of services. We will also be using (Maven)[https://maven.apache.org/] as our dependency and project manager. We will create a new Maven project and select import all necesary dependencies to our project. Once we have that we will start creating our application. We won't be going through the development of a REST API in this project, but there are plenty of resources out there for you to build a capable REST API. The class diagram for my particular Spring application looks like this:

<a href="https://github.com/UnaiZelaia/datu-atzipena23-24/blob/features/mongoMeteorites/images/class_diagram.svg" target="_blank"><img src="https://github.com/UnaiZelaia/datu-atzipena23-24/blob/features/mongoMeteorites/images/class_diagram.svg" width="60%" height="60%"/></a>

####Endpoint table

In our project, we will have several endpoints to interact with our data. In his table you can check the information about the endpoints I created to interact with this data:

| Endpoint URL             | Method | Parameters                | Request  Body*       | description
|--------------------------|--------|---------------------------|----------------------|------------------------------------------------------------|
| /api/v1/impacts          |  GET   | none                      | no                   | returns all the data from meteorite impacts                |
| /api/v1/impact           |  GET   | id(integer). Example id=2 | no                   | returns the data from the selected meteorite impact        |
| /api/v1/newImpact        |  POST  | none                      | yes                  | inserts a new record of a meteorite impact                 |
| /api/v1/updateImpact     |  PUT   | id(integer). Example id=2 | yes                  | modifies a meteorite impact record                         |
| /api/v1/deleteImpact     | DELETE | none                      | yes                  | Deletes the record corresponding with the requestBody sent |
| /api/v1/deleteImpactById  | DELETE | id(integer). EXAMPLE id=2 | no                  | Deltes the record with the id sent as a parameter          |

*Example of a requestBody:
  {
  "impactId": 0,
  "fall": "string",
  "geolocation": {
    "coordinates": [
      0,0
    ],
    "type": "string"
  },
  "mass": "string",
  "name": "string",
  "nametype": "string",
  "reclat": "string",
  "reclong": "string",
  "year": "string"
}

With all these endpoint you have a pretty bid control over the data and you will be able to do CRUD operation on it while sending HTTP requests. I have developed this using Swagger, an automatic, OpenAPI v3
compliant documentation generator and endpoint teste (pretty neat tool) and we can see and try all our endpoints there.  
<a href="https://github.com/UnaiZelaia/datu-atzipena23-24/blob/features/mongoMeteorites/images/swagger_mongo.png" target="_blank"><img src="https://github.com/UnaiZelaia/datu-atzipena23-24/blob/features/mongoMeteorites/images/swagger_mongo.png" width="60%" height="60%"/></a>


