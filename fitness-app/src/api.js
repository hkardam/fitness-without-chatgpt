import axios from "axios"; 

const baseURL = 'http://10.42.0.1:8080/exerciseservice'

export function getExercise(id) {
    return axios.get(baseURL+'/exercise/' + id);
}

export function getAllExercise() {
    return axios.get(baseURL+'/exercise');
}

export function addExercise(exercise) {
    return axios.post(baseURL+'/exercise', exercise);
}

export function updateExercise(exercise) {
    return axios.put(baseURL+'/exercise/' + exercise.id, exercise);
}

export function deleteExercise(id) {
    return axios.delete(baseURL+'/exercise/' + id);
}
