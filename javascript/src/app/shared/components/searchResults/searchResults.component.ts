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

  private searchResults: any;
  private searchTerm: any;

  constructor(private SearchResultsService:SearchResultsService,private route: ActivatedRoute) {

     console.log('inside search results');
     // this.searchTerm = route.snapshot.data['term'];
     // this.search();
     route.params.subscribe(
      data => {
        this.searchTerm = data['term'];
        this.search();
      });
  }

  search(){
      if(this.searchTerm.length > 3){
  	  	this.SearchResultsService.search(this.searchTerm).subscribe(results =>{
              this.searchResults = JSON.parse(results);
        },
        error => {
              console.log('Search Error'+error);
        });
      }else{
        this.searchResults = [];
      }
  }
}