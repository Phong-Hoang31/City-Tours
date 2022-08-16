import axios from 'axios';

export default {

    createItinerary(itinerary) {
        return axios.post(`/itineraries`, itinerary)
    },

    getAllItineraries() {
        return axios.get('/itineraries')
    },

    addLandmarkToItinerary(itinerary, landmark) {
        return axios.post(`/itineraries/${itinerary.itineraryId}/${landmark.landmarkID}`)
    },

    deleteLandmarkFromItinerary(itinerary, landmark) {
        return axios.delete(`/itineraries/${itinerary.itineraryId}/${landmark.landmarkID}`)
    },

    updateItineraryStartingPoint(itinerary, startingPoint) {
        return axios.put(`/itineraries/${itinerary.itineraryId}`, startingPoint)
    }
}