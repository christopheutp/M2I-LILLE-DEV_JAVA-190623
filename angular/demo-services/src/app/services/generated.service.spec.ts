import { TestBed } from '@angular/core/testing';

import { GeneratedService } from './generated.service';

describe('GeneratedService', () => {
  let service: GeneratedService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GeneratedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
