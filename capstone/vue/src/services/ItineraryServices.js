import axios from 'axios';
export default {

    createItinerary(startingPoint, date) {
        return axios.post(`/createItinerary`, {
            startingPoint: startingPoint,
            date: date
        });
    },
    getItineraryByUserId(userId) {
        return axios.get(`/itinerary/${userId}`);
    },
    getAllItineraries() {
        return axios.get('/itineraries')
    },


}