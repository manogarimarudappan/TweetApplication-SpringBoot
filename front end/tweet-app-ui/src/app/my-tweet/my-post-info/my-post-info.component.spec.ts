import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyPostInfoComponent } from './my-post-info.component';

describe('MyPostInfoComponent', () => {
  let component: MyPostInfoComponent;
  let fixture: ComponentFixture<MyPostInfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyPostInfoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyPostInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
