import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8081/api/v1',  // Adres backendu (Spring Boot API)
  headers: {
    'Content-Type': 'application/json'
  }
});

export default instance;