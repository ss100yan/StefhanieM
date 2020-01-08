/*
 *TypeScript is a superset of JavaScript. This means that all valid JavaScript is valid TypeScript, but the opposite is not true. So let's start by creating a class:
 */

 export class SuperPet{

    /*
     *Now let's give our class some fields/properties. Note that we can encapsulate this class in TypeScript using access modifiers. However, there are only three access modifiers: private, protected, and public.
     */

    private id:number;
    private name:string;
    private color:string;
    private power:string;
    //If nothing is specified, a field is by default public.
    age:number;

    //Here is how we define a constructor:
    constructor(id:number, name:string, color:string, power:string, age:number){
        this.id = id;
        this.name = name;
        this.color = color;
        this.power = power;
        this.age = age;
    }

    /*
     *We can create a return type for functions to guarantee that they only return certain data types (or "any" data type).
     */
    getId():number{
        return this.id;
    }

    setId(id:number){
        this.id = id;
    }

    getName():string{
        return this.name;
    }

    setName(name:string){
        this.name = name;
    }

    getColor():string{
        return this.color;
    }

    setColor(color:string){
        this.color = color;
    }

    getPower():string{
        return this.power;
    }

    setPower(power:string){
        this.power = power;
    }

    getAge():number{
        return this.age;
    }

    setAge(age:number){
        this.age = age;
    }
 }
