package main

import (
	"net/http"
	"strconv"

	"github.com/gin-gonic/gin"
)

func main() {
	address := "0.0.0.0:8000"
	router := gin.Default()

	router.GET("/kontatu", Kontatu)
	router.Run(address)
}

func Kontatu(c *gin.Context) {
	var emaitza string
	param, err := strconv.Atoi(c.Query("norarte"))
	if err != nil {
		println(err.Error())
	}
	for i := 1; i <= param; i++ {
		emaitza += strconv.Itoa(i) + "\n"
	}
	c.String(http.StatusOK, emaitza)
}
