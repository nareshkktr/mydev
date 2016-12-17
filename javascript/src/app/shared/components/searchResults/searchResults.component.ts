import { Component,EventEmitter,Input,Output } from '@angular/core';
import { SearchResultsService } from './searchResults.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'search-results',
  templateUrl:'./searchResults.component.html',
  styleUrls: ['./searchResults.component.css'],
  providers: [SearchResultsService]
})

export class SearchResultsComponent{

  private allSearchResults: any;
  private searchTerm: any;
  private searchObjectTypes: any;
  private totalResults: any;
  private searchObjectTypesResultsCount: any;

  constructor(private SearchResultsService:SearchResultsService,private route: ActivatedRoute) {

     console.log('inside search results');
  
     route.params.subscribe(
      data => {
        this.searchTerm = data['term'];
        this.search();
      });
  }

  search(){
      if(this.searchTerm.length >=3){
  	  	this.SearchResultsService.search(this.searchTerm).subscribe(results =>{
              let searchResults = JSON.parse(results);
              this.searchObjectTypes = Object.keys(searchResults);
              this.totalResults=0; 
              this.searchObjectTypesResultsCount = [];
              this.allSearchResults = [];
              for(let i=0;i<this.searchObjectTypes.length;i++){
              		let eachSearchTypeResultLength=searchResults[this.searchObjectTypes[i]].length;		
              		this.searchObjectTypesResultsCount.push(eachSearchTypeResultLength);
              		this.totalResults+=eachSearchTypeResultLength;
              		this.allSearchResults.push(searchResults[this.searchObjectTypes[i]]);
              }
              if(this.searchObjectTypes.length>0){
              	this.allSearchResults=this.allSearchResults[0];
              }
        },
        error => {
              console.log('Search Error'+error);
        });
      }else{
        this.allSearchResults = [];
      }
  }
}