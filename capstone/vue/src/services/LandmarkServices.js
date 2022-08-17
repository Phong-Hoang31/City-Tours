import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getLandmarks() {
        return http.get('/landmarks');
    },

    getImagesByLandmarkId(landmarkId) {
        return http.get(`/landmarks/${landmarkId}/images`);
    },

    getLandmark(landmarkId) {
        return http.get(`/landmarks/${landmarkId}`)
    },

    updateUpRatingsForLandmark(landmarkId) {
        return axios.put(`landmarks/${landmarkId}/upRatings`)
    },

    updateDownRatingsForLandmark(landmarkId) {
        return axios.put(`landmarks/${landmarkId}/downRatings`)
    },
}
