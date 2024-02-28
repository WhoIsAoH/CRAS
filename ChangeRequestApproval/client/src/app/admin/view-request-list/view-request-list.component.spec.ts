import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRequestListComponent } from './view-request-list.component';

describe('ViewRequestListComponent', () => {
  let component: ViewRequestListComponent;
  let fixture: ComponentFixture<ViewRequestListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRequestListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewRequestListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
