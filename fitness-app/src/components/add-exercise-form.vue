<template>
    <div>
        <div class="row">
            <div class="col-3">Exercise</div>
            <div class="col-3">Sets</div>
            <div class="col-3">Rep</div>
        </div>
        <div class="row mb-2">
            <div class="col-3">
                <select class="form-select" v-model="form.name">
                    <option>A</option>
                    <option>B</option>
                    <option>C</option>
                    <option>D</option>
                    <option>E</option>
                </select>
            </div>
            <div class="col-3">
                <input class="form-control" v-model.number="form.sets" type="number" step="1" min="0" placeholder="3" />
            </div>
            <div class="col-3">
                <input class="form-control" v-model.number="form.rep" type="number" step="1" min="0" placeholder="10" />
            </div>
            <div class="col-3 text-end">
                <button class="btn btn-sm btn-primary" @click="submitForm" :disabled="disableSubmit">
                    <b-icon icon="plus"></b-icon>
                    <span>Add</span>
                </button>
            </div>
        </div>
    </div>
</template>

<script>
import { addExercise } from '../api';
export default {
    name: "ExerciseItem",
    data() {
        return {
            form: {
                id: 0,
                name: null,
                sets: null,
                rep: null,
            },
        };
    },
    computed: {
        disableSubmit() {
            return !this.form.name || !this.form.sets || !this.form.rep
        }
    },
    methods: {
        submitForm() {
            console.log(this.form);
            addExercise(this.form)
            .then((resp) => {
                this.$store.commit('addExercise', {
                    ...this.form,
                    id: resp.data
                });
                this.form = {
                    name: null,
                    sets: null,
                    rep: null,
                };
            })
            .catch((err) => {
                console.log(err);
            });
        },
    },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
