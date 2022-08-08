import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getLandmarks() {
        return http.get('/landmarks');
    },
    // getLandmark(landmarkId) {
    //     return http.get(`/landmarks/${landmarkId}`)
    // },
}
