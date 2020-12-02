const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
  console.log(`Received request ${req.method} ${req.originalUrl}`)
  const response = 'Hello from Node!'
  console.log(`Returning: ${response}`)
  res.send(response)
})

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})
